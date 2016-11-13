package action.user;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class ImageUploadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 用户上传的文件
    private File                 uploadFile;  
    // 上传文件的文件名
    private String              uploadFileFileName;  
    // 上传文件的类型  
    private String              uploadFileContentType;                     
    //uploadfile 属性getter方法
	public File getUploadFile() {
		return uploadFile;
	}
	//uploadfile属性setter方法
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	//uploadfilefilename属性getter方法
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	//uploadfilefilename属性setter方法
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	//uploadfilecontenttype属性getter方法
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	//uploadfilecontenttype属性setter方法
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	//重载execute方法
	public String execute() throws Exception
    {		
        if (uploadFile!= null)
        {      	  
        	// 上传文件存放的目录
            String dataDir = "\\upload\\";
            // 上传文件在服务器具体的位置
            File savedFile = new File(dataDir, uploadFileFileName);
            // 将上传文件从临时文件复制到指定文件
            uploadFile.renameTo(savedFile);
        }
        else
        {
            return INPUT;
        }

        return SUCCESS;
    }

}
