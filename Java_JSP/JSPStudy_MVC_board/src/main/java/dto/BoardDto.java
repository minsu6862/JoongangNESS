package dto;

public class BoardDto {
	private int bnum;
	private String btitle, bcontent, memberid;
	private int bhit;
	private String bdate;
	
	private MemberDto memberDto;	//회원정보 클래스로 선언한 객체를 멤버 변수 영입

	public BoardDto() {
		
	}

	public BoardDto(int bnum, String btitle, String bcontent, String memberid, int bhit, String bdate,
			MemberDto memberDto) {
		this.bnum = bnum;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.memberid = memberid;
		this.bhit = bhit;
		this.bdate = bdate;
		this.memberDto = memberDto;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public MemberDto getMemberDto() {
		return memberDto;
	}

	public void setMemberDto(MemberDto member) {
		this.memberDto = member;
	}
	
	
}
