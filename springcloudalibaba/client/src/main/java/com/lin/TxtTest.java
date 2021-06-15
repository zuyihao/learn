package com.lin;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.List;

public class TxtTest {

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\customer.txt";
        String encoding="UTF-8";
        File file=new File(filePath);
        if(file.isFile() && file.exists()){ //判断文件是否存在
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
                int splitIndex = lineTxt.indexOf("|");
                String name = lineTxt.substring(0,splitIndex).trim();
                String contact = lineTxt.substring(splitIndex+1).trim();
                //System.out.println(name+"===="+contact);
                List<Contact> list = JSON.parseArray(contact,Contact.class);
                StringBuilder clist = new StringBuilder();
                list.forEach(c->{
                    clist.append(c.getName()).append(",").append(c.getTelephone()).append(",").append(c.getEmail()).append(";");
                });
                System.out.println(name+"\t"+clist);
            }
            read.close();
        }
    }
    class Contact {

        private String name;
        private String telephone;
        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
