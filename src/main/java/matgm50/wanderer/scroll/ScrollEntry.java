package matgm50.wanderer.scroll;

import net.minecraft.util.StatCollector;

import java.util.ArrayList;

public class ScrollEntry {

    private String key;
    private ArrayList<ScrollPage> pages = new ArrayList<ScrollPage>();

    public ScrollEntry(String key) {

        setKey(key);
        setPagesByCount(Integer.parseInt(StatCollector.translateToLocal("scroll." + key + ".pageCount")));

    }

    public ScrollEntry(String key, ScrollPage... pages) {

        setKey(key);
        setPages(pages);

    }

    public void setKey(String key) {

        this.key = key;

    }

    public String getKey() {

        return this.key;

    }

    public void setPages(ScrollPage... pages) {

        for(int i = 0; i < pages.length; i++) {

            (pages[i]).setText(StatCollector.translateToLocal("scroll." + key + ".text." + i));

            this.pages.add(pages[i]);

        }

    }

    public void setPagesByCount(int pageCount) {

        for(int i = 0; i < pageCount; i++) {

            ScrollPage page = new ScrollPage();

            page.setText(StatCollector.translateToLocal("scroll." + key + ".text." + i));

            this.pages.add(page);

        }

    }

    public ScrollEntry overridePage(int index, ScrollPage page) {

        pages.set(index, page);

        return this;

    }

    public ArrayList getPages() {

        return this.pages;

    }

    public ScrollPage getPage(int pageIndex) {

        return this.pages.get(pageIndex);

    }

}
