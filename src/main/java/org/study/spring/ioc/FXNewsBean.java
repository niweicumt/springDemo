package org.study.spring.ioc;

import lombok.Data;

/**
 * Created by niwei on 16/10/5.
 */
@Data
public class FXNewsBean {

    private String id;

    private String title;

    private String content;

    public FXNewsBean(String id) {
        this.id = id;
    }

}
