public class FileData {
    private String fileName;
    private int fileSize;
    private String filePatch;

    public FileData(String fileName, int fileSize, String filePatch) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePatch = filePatch;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFilePatch() {
        return filePatch;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", filePatch='" + filePatch + '\'' +
                '}';
    }
}
