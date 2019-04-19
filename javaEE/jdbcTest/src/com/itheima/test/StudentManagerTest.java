package com.itheima.test;

import com.itheima.domain.Student;
import com.itheima.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class StudentManagerTest {

    static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void main(String[] args) {
        //创建一个 存Student的ArrayList集合对象
        while (true) {
            System.out.println("-------欢迎来到学生管理系统---------");
            System.out.println("1 查看学生");
            System.out.println("2 添加学生");
            System.out.println("3 删除学生");
            System.out.println("4 修改学生");
            System.out.println("5 退出");
            System.out.println("请输入操作数字:");
            // 创建键盘录入对象Scanner
            Scanner sc = new Scanner(System.in);
            // 用户输入操作
            String choiceString = sc.nextLine();
            switch (choiceString) {
                case "1":
                    // 查看学生
                    findAllStudent();
                    break;
                case "2":
                    //添加学生
                    addStudent();
                    break;
                case "3":
                    //删除学生
                    deleteStudent();
                    break;
                case "4":
                    //修改学生
                    updateStudent();
                    break;
                case "5":
                    //退出
                default:
                    System.out.println("感谢您的使用");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void findAllStudent() {
		/*if(stuList.size()==0) { //没有学生对象的时候,提示用户
			System.out.println("现在还没有学生数据,请稍候再试....");
			return;//结束方法
		}

		System.out.println("学号\t姓名\t年龄\t地址\t");
		for (int i = 0; i < stuList.size(); i++) {
			Student s = stuList.get(i);//取出学生对象

			//打印出学生的详细信息
			System.out.println(s.getId()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());
		}*/

        List<Student> list = jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<Student>(Student.class));
        if (list.size() == 0) {
            System.out.println("没有学生，请去添加");
            return;
        }
        for (Student student : list) {
            System.out.println(student);
        }
    }


    public static void addStudent() {
        //创建键盘录入对象Scanner
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入学生学号:");
            id = sc.nextLine();
            try {
                Student student = jdbcTemplate.queryForObject("select * from student where id = ?", new BeanPropertyRowMapper<Student>(Student.class), id);
                //没出现异常，说明查到了
                System.out.println("学号重复，请重新输入");
            } catch (Exception e) {
                //出现异常，说明没有查到
                System.out.println("请输入学生姓名:");
                String name = sc.nextLine();
                System.out.println("请输入学生年龄:");
                String age = sc.nextLine();
                System.out.println("请输入学生地址:");
                String address = sc.nextLine();
                int rows = jdbcTemplate.update("insert into student(id,name,age,address) values(?,?,?,?)", id, name, age, address);
                if (rows > 0) {
                    System.out.println("添加成功");
                    break;
                } else {
                    System.out.println("添加失败");
                }
            }
        }
    }


    public static void deleteStudent() {
        //创建键盘录入的对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号:");
        //用户输入的学生id
        String id = sc.nextLine();

        int rows = jdbcTemplate.update("delete from student where id = ?", id);
        if (rows > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    public static void updateStudent() {
        //创建键盘录入的对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号:");


        //用户输入的学生id
        String id;
        while (true) {
            id = sc.nextLine();
            try {
                Student student = jdbcTemplate.queryForObject("select * from student where id = ?", new BeanPropertyRowMapper<Student>(Student.class), id);
                //没出现异常，说明查到了
                System.out.println("请输入学生姓名:");
                String name = sc.nextLine();
                System.out.println("请输入学生年龄:");
                String age = sc.nextLine();
                System.out.println("请输入学生地址:");
                String address = sc.nextLine();
                int rows = jdbcTemplate.update("update student set name=?,age=?,address = ? where id = ?", name, age, address, id);
                if (rows > 0) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }
                break;
            } catch (Exception e) {
                //出现异常，说明没有查到
                System.out.println("没有该学号的学生，请重新输入学号");
            }
        }
       /* int index = -1;//用来记录查找学生的索引
        //遍历集合数组,找到每一个学生,然后取出学生的学号
        for (int i = 0; i < stuList.size(); i++) {
            //取出学生
            Student student = stuList.get(i);
            //取出学生的学号
            String idNumber = student.getId();
            if (idNumber.equals(id)) {//用equals方法判断 学号是用户输入的学号是否一致
                index = i;
                break;//找到学生之后,保留学生的索引,然后停止循环
            }
        }
        if (index == -1) {//如果经过了循环还等于-1   说明没有找到学生
            System.out.println("没有这样学号的学生");
        } else {
            System.out.println("请输入学生新的姓名:");
            String name = sc.nextLine();
            System.out.println("请输入学生新的年龄:");
            String age = sc.nextLine();
            System.out.println("请输入学生新的地址:");
            String address = sc.nextLine();
            //创建新的学生对象
            Student s = new Student();
            s.setId(id);
            s.setAddress(address);
            s.setAge(age);
            s.setName(name);
            //替换原来位置的学生
            stuList.set(index, s);
            System.out.println("修改成功");
        }
*/
    }
}
