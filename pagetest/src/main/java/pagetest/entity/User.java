package pagetest.entity;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * user_tab
	 */
	private static final long serialVersionUID = -1608098811772243808L;
	
	private String userID_col;
	private String passwo_col;
	private String useNam_col;
	private String region_col;
	private String group_col;
	private String bu_col;
	private String dept_col;
	private String noteID_col;
	private String active_col;
	private int logTim_col;
	private String laLoDa_col;
	private long laLoIn_col;
	private String creUID_col;
	private String creDat_col;
	private String laMoBy_col;
	private String laMoDa_col;
	private String email_col;
	
	public User() {
		super();
	}

	public User(String userID_col, String passwo_col, String bu_col,String useNam_col) {
		super();
		this.userID_col = userID_col;
		this.useNam_col = useNam_col;
		this.passwo_col = passwo_col;
		this.bu_col = bu_col;
	}

	public void setUserID_col(String s) {
		this.userID_col = s;
	}

	public void setPasswo_col(String s) {
		this.passwo_col = s;
	}

	public void setUseNam_col(String s) {
		this.useNam_col = s;
	}

	public void setRegion_col(String s) {
		this.region_col = s;
	}

	public void setGroup_col(String s) {
		this.group_col = s;
	}

	public void setBu_col(String s) {
		this.bu_col = s;
	}

	public void setDept_col(String s) {
		this.dept_col = s;
	}

	public void setNoteID_col(String s) {
		this.noteID_col = s;
	}

	public void setActive_col(String s) {
		this.active_col = s;
	}

	public void setLogTim_col(int s) {
		this.logTim_col = s;
	}

	public void setLaLoDa_col(String s) {
		this.laLoDa_col = s;
	}

	public void setLaLoIn_col(long s) {
		this.laLoIn_col = s;
	}

	public void setCreUID_col(String s) {
		this.creUID_col = s;
	}

	public void setCreDat_col(String s) {
		this.creDat_col = s;
	}

	public void setLaMoBy_col(String s) {
		this.laMoBy_col = s;
	}

	public void setLaMoDa_col(String s) {
		this.laMoDa_col = s;
	}

	public void setEmail_col(String s) {
		this.email_col = s;
	}

	public String getUserID_col() {
		return this.userID_col;
	}

	public String getPasswo_col() {
		return this.passwo_col;
	}

	public String getUseNam_col() {
		return this.useNam_col;
	}

	public String getRegion_col() {
		return this.region_col;
	}

	public String getGroup_col() {
		return this.group_col;
	}

	public String getBu_col() {
		return this.bu_col;
	}

	public String getDept_col() {
		return this.dept_col;
	}

	public String getNoteID_col() {
		return this.noteID_col;
	}

	public String getActive_col() {
		return this.active_col;
	}

	public int getLogTim_col() {
		return this.logTim_col;
	}

	public String getLaLoDa_col() {
		return this.laLoDa_col;
	}

	public long getLaLoIn_col() {
		return this.laLoIn_col;
	}

	public String getCreUID_col() {
		return this.creUID_col;
	}

	public String getCreDat_col() {
		return this.creDat_col;
	}

	public String getLaMoBy_col() {
		return this.laMoBy_col;
	}

	public String getLaMoDa_col() {
		return this.laMoDa_col;
	}

	public String getEmail_col() {
		return this.email_col;
	}
	
	@Override
	public String toString() {
		return "userName " + this.useNam_col + ", pasword " + this.passwo_col + "sbu " + this.bu_col;
	}
}