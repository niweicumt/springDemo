package org.study.spring.ioc;

import org.study.spring.ioc.intf.IFXNewsPersister;

/**
 * Created by niwei on 16/10/5.
 */
public class DowJonesNewsPersister implements IFXNewsPersister {

    public void persistNews(FXNewsBean fxNewsBean) {
        System.out.println("Here is persist newsBean to DB. And news id is : " + fxNewsBean.getId());
    }
}
