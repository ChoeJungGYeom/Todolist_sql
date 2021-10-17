package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class TodoItem {
	private int ID;
	private int is_completed;
    private String title;
    private String desc;
    private String current_date;
    private String category;
    private String due_date;
    private int importance;
    private String whowith;


    public TodoItem(String title, String desc, String category, String due_date, int ID, String current_date, int is_completed, int importance, String whowith){
        this.title=title;
        this.category = category;
        this.desc=desc;
        this.due_date = due_date;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.ID = ID;
        this.is_completed = is_completed;
        this.current_date= current_date;
        this.importance = importance;
        this.whowith = whowith;
    }
    
    public TodoItem(String title, String desc, String category, String due_date, int ID, String current_date, int importance, String whowith){
        this.title=title;
        this.category = category;
        this.desc=desc;
        this.due_date = due_date;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.ID = ID;
        this.is_completed = 0;
        this.current_date= current_date;
        this.importance = importance;
        this.whowith = whowith;
    }
//    
//    public TodoItem(String title, String desc, String category, String due_date, int ID, String current_date, int is_completed){
//        this.title=title;
//        this.category = category;
//        this.desc=desc;
//        this.due_date = due_date;
//        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
//        this.ID = ID;
//        this.is_completed = is_completed;
//        this.current_date= current_date;
//    }
    
//    public TodoItem(String title, String desc, String category, String due_date, int ID, String current_date){
//        this.title=title;
//        this.category = category;
//        this.desc=desc;
//        this.due_date = due_date;
//        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
//        this.ID = ID;
//        this.is_completed = 0;
//        this.current_date= current_date;
//        
//    }
//    
    public TodoItem(String title, String desc, String category, String due_date, int importance, String whowith){
        this.title=title;
        this.category = category;
        this.desc=desc;
        this.due_date = due_date;
        this.is_completed = 0;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date=f.format(new Date());
        this.importance = importance;
        this.whowith = whowith;
    }
    
    public TodoItem(String title, String desc, String category, String due_date){
        this.title=title;
        this.category = category;
        this.desc=desc;
        this.due_date = due_date;
        this.is_completed = 0;
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        this.current_date=f.format(new Date());
    }

//	public TodoItem(StringTokenizer st) {
//		this.title = st.nextToken();
//		this.category = st.nextToken();
//		this.desc = st.nextToken();
//		this.due_date = st.nextToken();
//		this.current_date = st.nextToken();
//	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
    	this.current_date = current_date;
    }
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	@Override
    public String toString() {
		String completed = "[X]";
		if(is_completed == 1) 
			completed = "[V]";
		
    	return ID + ". " + "[" + category + "]" + title +" with "+ whowith + completed + " - " + desc + " - " + due_date + " - " + current_date+ " - Importance : " + importance;
    }
    
//    public String toSaveString() {
//    	return title + "##" + category + "##" + desc + "##" + due_date + "##" + current_date + "\n";
//    }

	public int getID() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public int getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(int is_completed) {
		this.is_completed = is_completed;
	}
	
	
	public void setImportance(int importance) {
		this.importance = importance;
	}

	public String getWhowith() {
		return whowith;
	}

	public void setWhowith(String whowith) {
		this.whowith = whowith;
	}
	
	public int getImportance() {
		return importance;
	}

}