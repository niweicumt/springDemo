package org.study.spring.ioc.intf;

import org.study.spring.ioc.FXNewsBean;

/**
 * Created by niwei on 16/10/5.
 */
public interface IFXNewsPersister {
    void persistNews(FXNewsBean fxNewsBean);
}
