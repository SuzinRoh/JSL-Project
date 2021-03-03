package project.domain.user;

public class UserPortVO {
	private int port_num;
	private int user_num;
	private String port_private;
	private int port_readcnt;
	private String port_regidate;
	private String port_modifydate;
	private String port_link;
	public String getPort_link() {
		return port_link;
	}
	public void setPort_link(String port_link) {
		this.port_link = port_link;
	}
	public int getPort_num() {
		return port_num;
	}
	public void setPort_num(int port_num) {
		this.port_num = port_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getPort_private() {
		return port_private;
	}
	public void setPort_private(String port_private) {
		this.port_private = port_private;
	}
	public int getPort_readcnt() {
		return port_readcnt;
	}
	public void setPort_readcnt(int port_readcnt) {
		this.port_readcnt = port_readcnt;
	}
	public String getPort_regidate() {
		return port_regidate;
	}
	public void setPort_regidate(String port_regidate) {
		this.port_regidate = port_regidate;
	}
	public String getPort_modifydate() {
		return port_modifydate;
	}
	public void setPort_modifydate(String port_modifydate) {
		this.port_modifydate = port_modifydate;
	}
	public String getPort_filename() {
		return port_filename;
	}
	public void setPort_filename(String port_filename) {
		this.port_filename = port_filename;
	}
	private String port_filename;
}
