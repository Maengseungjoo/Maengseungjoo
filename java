//초기화면과 Member, MemberMain 클래스입니다.

*********************************
    다음 메뉴 중 하나를 선택하세요.    
*********************************
1 : 회원 추가
2 : 회원 목록 보기
3 : 회원 정보 수정하기
4 : 회원 삭제
5 : 종료



package firstEx.lib;

public class Member {
	private String name;
	private String phoneNumber;
	private String address;
	private String classify;
	
	public Member(String name, String phoneNumber, String address, String classify) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.classify = classify;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getClassify() {
		return classify;
	}

}


package firstEx.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import firstEx.lib.Member;

public class MemberMain {
		
//		화면에 메뉴출력하는 메소드 선언
		private static void printMenu() {
			System.out.println("*********************************");
			System.out.println("    다음 메뉴 중 하나를 선택하세요.    ");
			System.out.println("*********************************");
			System.out.println("1 : 회원 추가");
			System.out.println("2 : 회원 목록 보기");
			System.out.println("3 : 회원 정보 수정하기");
			System.out.println("4 : 회원 삭제");
			System.out.println("5 : 종료");
		}
		
//		1. 회원 추가 메소드
		private static void addMember(HashMap<String, Member> members
				, Scanner scan) {
			System.out.println("등록할 회원의 정보를 입력하세요.");
			
			System.out.print("이름: ");
			String name = scan.next();
			System.out.print("전화번호(ex: 01012345678): ");
			String phoneNumber = scan.next();
			System.out.print("주소: ");
			String address = scan.next();
			System.out.print("종류(ex.가족, 친구, 회사, 기타): ");
			String classify = scan.next();
			
//			Student object 생성
			Member member = new Member(name, phoneNumber, address, classify);
//			HM put
			members.put(phoneNumber, member);	
			System.out.println("=====================================");
			System.out.println("=             회원 추가 완료           =");
			System.out.println("=====================================");
			System.out.println(member.toString());
		}
		
//		2. 화면출력 메소드
		private static void printMembers(HashMap<String, Member> members) {
			Iterator<String> it = members.keySet().iterator();
			while(it.hasNext()) {
				System.out.println(members.get(it.next()));
			}
		}
		
//		3. 회원정보수정 메소드
		private static void editMember(HashMap<String, Member> members) {
			System.out.println("회원정보수정 메뉴");
			
		}
//		4. 회원삭제 메소드
		private static void removeMember(HashMap<String, Member> members) {
			System.out.println("회원삭제 메뉴");
			
		}
		
		public static void main(String[] args) {
			HashMap<String, Member> members = new HashMap<>();
			Scanner scan = new Scanner(System.in);
			while(true) {
				printMenu();  // 메뉴 출력
				String select = scan.next();
				switch(select) {
				case "1" :
					System.out.println("회원추가");
//					학생 추가 메소드 호출
					addMember(members, scan);
					break;
				case "2" :
					System.out.println("회원 목록 보기");
//					학생 목록 화면출력 메소드 호출
					printMembers(members);
					break;
				case "3" :
					System.out.println("회원 정보 수정하기");
					editMember(members);
				case "4" :
					System.out.println("회원 삭제");
					removeMember(members);
				case "5" :
					System.out.println("프로그램 종료");
					break;
				default:
					System.out.println("잘못 입력 : 1~3 입력");
				}
				if(select.equals("3")) {
					break; // while 종료하는 break
				}
			}
		}
	}
