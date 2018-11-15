package kr.or.ddit.web.useragent;

public enum Selected {
	GUGUDAN("gugudan","/01/gugudanForm.html"), 
	LYRICS("lyrics","/02/musicForm.jsp"), 
	CALENDAR("calendar","/04/calendar.jsp"), 
	IMAGE("image","/imageForm"),
	BASIC("basic","/");
	
	private String param;
	private String url;
	
	private Selected(String param, String url) {
		this.param = param;
		this.url = url;
	}
	
	public String getParam() {
		return param;
	}
	
	public String getUrl() {
		return url;
	}

	public static Selected getSelected(String command){
		Selected result = Selected.BASIC;
		Selected[] types = values();
		for(Selected tmp : types) {
			if(command.toUpperCase().contains(tmp.name())){
				result = tmp;
				break;
			}
		}
		return result;
	}

}
