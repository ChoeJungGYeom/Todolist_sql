package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("<ToDoList ���� ��ɾ� ����>");
        System.out.println("1. [add] - �׸� �߰�");
        System.out.println("2. [del] - �׸� ����");
        System.out.println("3. [edit] - �׸� ����");
        System.out.println("4. [ls] - ��ü ���");
        System.out.println("5. [ls_name] - �̸� �������� ����");
        System.out.println("6. [ls_name_desc] - �̸� �������� ����");
        System.out.println("7. [ls_date] - ��¥ �������� ����");
        System.out.println("8. [ls_date_desc] - ��¥ �������� ����");
        System.out.println("9. [ls_cate] - ī�װ��� ����");
        System.out.println("10. [ls_comp] - �Ϸ��׸� ����");
        System.out.println("11. [comp <Ű����>] - <Ű����> �׸� �Ϸ� üũ");
        System.out.println("12. [find <Ű����>] - <Ű����>�� �����ϰ� �ִ� �׸��� ���");
        System.out.println("13. [find_cate <Ű����>] - <Ű����>�� �����ϰ� �ִ� ī�װ��� ���");
        System.out.println("14. [exit] - ����");
    }
    
    public static void prompt() {
    	displaymenu();
    }
}