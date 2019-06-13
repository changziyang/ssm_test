package cn.ziyang.mapper;

import cn.ziyang.domain.Student;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface StudentMapper {
    /**
     * 查询全部
     * @return
     */
    public List<Student> findAll();
    /**
     * 添加
     */
    public void add(Student student);
    /**
     * 修改
     */
    public void update(Student student);
    /**
     * 删除
     */
    public void del(Integer[] ids);

    public Student findOne(int id);


}
