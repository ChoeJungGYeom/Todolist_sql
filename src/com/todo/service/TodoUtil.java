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
		
		System.out.println("[�׸� �߰�] \n"
				+ "���� > ");
		
		title = sc.nextLine().trim();
		if (l.isDuplicate(title)) {
			System.out.printf("������ �ߺ��˴ϴ�!");
			return;
		}
		
		System.out.println("ī�װ� > ");
		category = sc.next();
		sc.nextLine();
		System.out.println("���� > ");
		desc = sc.nextLine().trim();
		
		System.out.println("�������� > ");
		due_date = sc.nextLine().trim();
		
		System.out.println("�߿䵵 > ");
		importance = sc.nextInt();
		sc.nextLine();
		
		System.out.println("������? > ");
		whowith = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc, category, due_date, importance, whowith);
		if(l.addItem(t) > 0)
			System.out.println("������ �߰��Ǿ����ϴ�.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸� ����]\n"
				+ "������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		
		int index = sc.nextInt();
		sc.nextLine();

		if(l.deleteItem(index) > 0) {
			System.out.println("�����Ǿ����ϴ�.");
		} else {
			System.out.println("������ �����Ͽ����ϴ�.");
		}
	}

	public static void updateItem(TodoList l) {
		
		String new_title, new_desc, new_category, new_due_date, new_whowith;
		int new_importance;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[�׸� ����]\n"
				+ "������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		
		int index = sc.nextInt();
		sc.nextLine();
		System.out.println("�� ���� > ");
		new_title = sc.nextLine().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("�ߺ��� �����Դϴ�!");
			return;
		}
		
		System.out.println("�� ī�װ� > ");
		new_category = sc.nextLine().trim();
		
		System.out.println("�� ���� > ");
		new_desc = sc.nextLine().trim();
		
		System.out.println("�� �������� > ");
		new_due_date = sc.nextLine().trim();
		
		System.out.println("�� �߿䵵 > ");
		new_importance = sc.nextInt();
		sc.nextLine();
		
		System.out.println("�����ϴ� ��� > ");
		new_whowith = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(new_title, new_desc, new_category, new_due_date,new_importance,new_whowith);
		t.setId(index);
		if(l.updateItem(t) > 0)
			System.out.println("�����Ǿ����ϴ�.");
		
	}
	
	public static void completeItem(TodoList l, String num) {
		
		if(l.completeItem(num) > 0)
			System.out.println("üũ �Ϸ��Ͽ����ϴ�.");
		else
			System.out.println("üũ�� �����Ͽ����ϴ�.");
		
	}

	public static void find(TodoList l, String keyword) {
		int count = 0;
		for(TodoItem item : l.getList(keyword)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.println("\n�� " + count + "���� �׸��� ã�ҽ��ϴ�.");
	}
	
	public static void findCateList(TodoList l, String cate) {
		int count = 0;
		for (TodoItem item : l.getListCategory(cate)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n �� %d���� �׸��� ã�ҽ��ϴ�.\n", count);
	}

	public static void listAll(TodoList l) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
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
		System.out.printf("[��ü ���, �� %d��]\n",l.getCount());
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
		System.out.printf("\n �� %d���� �׸��� ã�ҽ��ϴ�.\n", count);
	}
}