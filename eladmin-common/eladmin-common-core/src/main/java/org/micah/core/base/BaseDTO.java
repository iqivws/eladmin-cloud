package org.micah.core.base;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.micah.core.excel.TimeStampCustomConverter;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @program: eladmin-cloud
 * @description:
 * @author: Micah
 * @create: 2020-08-05 15:21
 **/
@Setter
@Getter
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 6671254728536647457L;

    @ExcelIgnore
    private String createBy;

    @ExcelIgnore
    private String updatedBy;

    @ExcelProperty(value = "创建日期",converter = TimeStampCustomConverter.class)
    private Timestamp createTime;

    @ExcelProperty(value = "更新日期",converter = TimeStampCustomConverter.class)
    private Timestamp updateTime;

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                builder.append(f.getName(), f.get(this)).append("\n");
            }
        } catch (Exception e) {
            builder.append("toString builder encounter an error");
        }
        return builder.toString();
    }
}
