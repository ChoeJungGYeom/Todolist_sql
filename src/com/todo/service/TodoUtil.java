package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList l) {
		
		String title, desc, category, due_date, whowith;
		int importance;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목 추가] \n"
				+ "제목 > ");
		
		title = sc.nextLine().trim();
		if (l.isDuplicate(title)) {
			System.out.printf("제목이 중복됩니다!");
			return;
		}
		
		System.out.println("카테고리 > ");
		category = sc.next();
		sc.nextLine();
		System.out.println("내용 > ");
		desc = sc.nextLine().trim();
		
		System.out.println("마감일자 > ");
		due_date = sc.nextLine().trim();
		
		System.out.println("중요도 > ");
		importance = sc.nextInt();
		sc.nextLine();
		
		System.out.println("누구랑? > ");
		whowith = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc, category, due_date, importance, whowith);
		if(l.addItem(t) > 0)
			System.out.println("내용이 추가되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목 삭제]\n"
				+ "삭제할 항목의 번호를 입력하시오 > ");
		
		int index = sc.nextInt();
		sc.nextLine();

		if(l.deleteItem(index) > 0) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
	}

	public static void updateItem(TodoList l) {
		
		String new_title, new_desc, new_category, new_due_date, new_whowith;
		int new_importance;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[항목 수정]\n"
				+ "수정할 항목의 번호를 입력하시오 > ");
		
		int index = sc.nextInt();
		sc.nextLine();
		System.out.println("새 제목 > ");
		new_title = sc.nextLine().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("중복된 제목입니다!");
			return;
		}
		
		System.out.println("새 카테고리 > ");
		new_category = sc.nextLine().trim();
		
		System.out.println("새 내용 > ");
		new_desc = sc.nextLine().trim();
		
		System.out.println("새 마감일자 > ");
		new_due_date = sc.nextLine().trim();
		
		System.out.println("새 중요도 > ");
		new_importance = sc.nextInt();
		sc.nextLine();
		
		System.out.println("같이하는 사람 > ");
		new_whowith = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(new_title, new_desc, new_category, new_due_date,new_importance,new_whowith);
		t.setId(index);
		if(l.updateItem(t) > 0)
			System.out.println("수정되었습니다.");
		
	}
	
	public static void completeItem(TodoList l, String num) {
		
		if(l.completeItem(num) > 0)
			System.out.println("체크 완료하였습니다.");
		else
			System.out.println("체크에 실패하였습니다.");
		
	}

	public static void find(TodoList l, String keyword) {
		int count = 0;
		for(TodoItem item : l.getList(keyword)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.println("\n총 " + count + "개의 항목을 찾았습니다.");
	}
	
	public static void findCateList(TodoList l, String cate) {
		int count = 0;
		for (TodoItem item : l.getListCategory(cate)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n 총 %d개의 항목을 찾았습니다.\n", count);
	}

	public static void listAll(TodoList l) {
		System.out.printf("[전체 목록, 총 %d개]\n", l.getCount());
		for (TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
	
	public static void listAll(TodoList l, int num) {
		for (TodoItem item : l.getList(num)) {
			System.out.println(item.toString());
		}
	}
	
	public static void listAll(TodoList l, String orderby, int ordering) {
		System.out.printf("[전체 목록, 총 %d개]\n",l.getCount());
		for (TodoItem item : l.getOrderedList(orderby, ordering)) {
			System.out.println(item.toString());
		}
	}
	
	public static void listCateAll(TodoList l) {
		int count = 0;
		for(String item : l.getCategories()) {
			System.out.print(item + " ");
			count++;
		}
		System.out.printf("\n 총 %d개의 항목을 찾았습니다.\n", count);
	}
}