import java.util.*;
import java.util.stream.Collectors;

public class FileNavigator {
    private Map<String, List<FileData>> listFiles;

    public FileNavigator() {
        listFiles = new HashMap<>();
    }


    public void add(String pathKey, FileData fileData) {
        if (! pathKey.equals(fileData.getFilePatch())) {
            System.out.println("The entry could not be added. \n" +
                    "The entered path-key does not match the path specified in the file properties");
            return;
        }
        if (!listFiles.containsKey(pathKey)) {
            listFiles.put(pathKey, new ArrayList<>());
        }
        listFiles.get(pathKey).add(fileData);
    }

    public List<FileData> find(String pathFile) {
        if (! listFiles.containsKey(pathFile)) {
            System.out.println("There are no files in the specified path");
            return null;
        }
        return listFiles.get(pathFile);
    }

    public List<String> getFileName(String pathFile) {
        if (! listFiles.containsKey(pathFile)) {
            System.out.println("There are no files in the specified path");
            return null;
        }
        return listFiles.get(pathFile).stream().map(FileData::getFileName).collect(Collectors.toList());
    }


    public List<FileData> filterBySize(int sizeFile){
        List<FileData> fileDataList = new ArrayList<>();
        for (Map.Entry<String, List<FileData>> entry: listFiles.entrySet()) {
            for (FileData file: entry.getValue()) {
                if (file.getFileSize() <= sizeFile) fileDataList.add(file);
            }
        }
        return fileDataList;
    }

    public boolean remove (String pathFile) {
        if (listFiles.containsKey(pathFile)) {
            listFiles.remove(pathFile);
            return true;
        }
        return false;
    }


    public List<FileData> sortBySize() {
        List<FileData> files = new ArrayList<>();
        for (String key: listFiles.keySet()) {
            files.addAll(listFiles.get(key));
        }
        files.sort(new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                return o1.getFileSize() - o2.getFileSize();
            }
        });
        return files;
    }



    public Map<String, List<FileData>> getListFiles() {
        return listFiles;
    }
}
