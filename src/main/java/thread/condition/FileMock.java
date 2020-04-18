package thread.condition;

/**
 * @program: JustForFun
 * @description:
 * @author: leslie
 * @create: 2020-04-17 18:24
 **/
public class FileMock {
    /**
     *  存储文件的内容，
     */
    private String[] content;
    /**
     * 检索文件的行
     */
    private int index;

    public FileMock(int size, int length) {
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int randomChar = (int) Math.random() * 255;
                sb.append((char)randomChar);
            }
            content[i] =sb.toString();
        }
        index=0;
    }

    /**
     * 文件是否读到了末尾。
     * @return
     */
    public boolean hasMoreLines(){

        return  index <content.length;
    }

    //如果没读完,返回当前行
    public String getLines(){
        if(this.hasMoreLines()){
            System.out.printf("Mock: %d\n",content.length-index);
            return content[index++];
        }
        return  null;
    }
}
