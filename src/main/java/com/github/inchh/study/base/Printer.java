package com.github.inchh.study.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 打印机类
 *
 * @author In_Chh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Printer implements Equipment, java.io.Serializable {
    public static final long serialVersionUID = -23943929423523L;
    /**
     * 打印机名称
     */
    private String name;
    /**
     * 打印机类型
     */
    private String type;

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
