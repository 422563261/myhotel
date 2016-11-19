package action.user;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import service.UserService;

public class ImageUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private UserService userService;

	// �û��ϴ����ļ�
	private File uploadFile;
	// �ϴ��ļ����ļ���
	private String uploadFileFileName;
	// �ϴ��ļ�������
	private String uploadFileContentType;

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		if (uploadFile != null) {
			// �ϴ��ļ���ŵ�Ŀ¼
		
			String dataDir = System.getProperty("user.home")+"\\workspace\\Hotel\\WebContent\\upload\\";
			String image ="upload\\"+uploadFileFileName;
			// �ϴ��ļ��ڷ����������λ��
			File savedFile = new File(dataDir, uploadFileFileName);
			// ���ϴ��ļ�����ʱ�ļ����Ƶ�ָ���ļ�
			uploadFile.renameTo(savedFile);
			user.setPhoto(image);
			this.userService.update(user);

		} else {
			return INPUT;
		}

		return SUCCESS;
	}

}
