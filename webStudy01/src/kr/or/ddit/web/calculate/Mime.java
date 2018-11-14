package kr.or.ddit.web.calculate;

public enum Mime {
	
	PLAIN("text/plain;charset=UTF-8",new Result() {
		@Override
		public String getResult(String result) {
			return result;
		}
	}),
	JSON("application/json;charset=UTF-8", (result) -> {
		return "{\"result\":\""+result+"\"}";
	}), 
	HTML("text/html;charset=UTF-8",new Result() {
		@Override
		public String getResult(String result) {
			return "<p>"+result+"</p>";
		}
	}), 
	XML("application/xml;charset=UTF-8",new Result() {
		@Override
		public String getResult(String result) {
			return result;
		}
	});
	
	private String MimeType;
	private Result Iresult;
	
	Mime(String MimeType, Result result) {
		this.MimeType = MimeType;
		this.Iresult = result;
	}
	
	public String getMimeType() {
		return this.MimeType;
	}
	
	public String getResult(String result) {
		return Iresult.getResult(result);
	}

	//"text/plain;charset=UTF-8"
	//"application/json;charset=UTF-8"
	//"text/html;charset=UTF-8"
	//"application/xml;charset=UTF-8"

}
