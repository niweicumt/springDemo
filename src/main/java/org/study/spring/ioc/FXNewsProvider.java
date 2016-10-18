package org.study.spring.ioc;

import org.study.spring.ioc.intf.IFXNewsListener;
import org.study.spring.ioc.intf.IFXNewsPersister;

/**
 * Created by niwei on 16/10/5.
 */
public class FXNewsProvider {

    private IFXNewsListener newsListener;

    private IFXNewsPersister newsPersister;

    public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public void getAndPersistNews() {
        String[] newsIds = newsListener.getAvailableNewsIds();
        if (newsIds == null) {
            return;
        }

        for (String newsId : newsIds) {
            FXNewsBean fxNewsBean = newsListener.getNewsByPK(newsId);
            newsPersister.persistNews(fxNewsBean);
        }
    }
}
