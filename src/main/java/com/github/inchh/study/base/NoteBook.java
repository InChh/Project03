package com.github.inchh.study.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 笔记本类
 *
 * @author In_Chh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class NoteBook implements Equipment, java.io.Serializable {
    public static final long serialVersionUID = 34783473434L;
    /**
     * 笔记本型号
     */
    private String modal;
    /**
     * 笔记本价格
     */
    private double price;

    @Override
    public String getDescription() {
        return modal + "(" + price + ")";
    }
}
