package cn.fan.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Date 2020/4/30
 * @Create By admin
 */
@Data
public class BaseModel  implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
