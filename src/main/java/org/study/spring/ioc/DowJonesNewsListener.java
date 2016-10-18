package org.study.spring.ioc;

import org.study.spring.ioc.intf.IFXNewsListener;

/**
 * Created by niwei on 16/10/5.
 */
public class DowJonesNewsListener implements IFXNewsListener {

    public String[] getAvailableNewsIds() {
        String[] newsIds = {"1", "2", "3"};
        return newsIds;
    }

    public FXNewsBean getNewsByPK(String newsId) {
        return new FXNewsBean(newsId);
    }
}
