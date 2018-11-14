package kr.or.ddit.web.useragent;

public enum Practice {
	CHROME("크롬"), FIREFOX("파이어폭스"), OTHER("기타");
	
	private String browerName;
	
	public String getBrowerName() {
		return browerName;
	}

	Practice(String browerName){
		this.browerName = browerName;
	}
	
	public boolean check(String userAgent) {
		boolean check = false;
		for(Practice tmp:values()) {
			if(userAgent.toUpperCase().contains(tmp.name())) {
				check = true;
				break;
			}
		}
		return check;
	}
	
	
	public static Practice getPractice(String userAgent) {
		Practice result = OTHER;
		for(Practice tmp:values()) {
			if(tmp.check(userAgent)) {
				result = tmp;
				break;
			}
		}
		
		return result;
	}
}
