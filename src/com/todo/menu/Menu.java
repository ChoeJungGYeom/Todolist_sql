package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("<ToDoList 관리 명령어 사용법>");
        System.out.println("1. [add] - 항목 추가");
        System.out.println("2. [del] - 항목 삭제");
        System.out.println("3. [edit] - 항목 수정");
        System.out.println("4. [ls] - 전체 목록");
        System.out.println("5. [ls_name] - 이름 오름차순 정렬");
        System.out.println("6. [ls_name_desc] - 이름 내림차순 정렬");
        System.out.println("7. [ls_date] - 날짜 오름차순 정렬");
        System.out.println("8. [ls_date_desc] - 날짜 내림차순 정렬");
        System.out.println("9. [ls_cate] - 카테고리순 정렬");
        System.out.println("10. [ls_comp] - 완료항목 정렬");
        System.out.println("11. [comp <키워드>] - <키워드> 항목 완료 체크");
        System.out.println("12. [find <키워드>] - <키워드>를 포함하고 있는 항목을 출력");
        System.out.println("13. [find_cate <키워드>] - <키워드>를 포함하고 있는 카테고리를 출력");
        System.out.println("14. [exit] - 종료");
    }
    
    public static void prompt() {
    	displaymenu();
    }
}