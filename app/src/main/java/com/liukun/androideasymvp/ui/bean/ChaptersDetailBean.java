package com.liukun.androideasymvp.ui.bean;

import java.util.List;

/**
 * Author: liukun on 2020/6/7.
 * Mail  : 3266817262@qq.com
 * Description:
 */
public class ChaptersDetailBean {

    /**
     * curPage : 1
     * datas : [{"apkLink":"","audit":1,"author":"Android群英传","canEdit":false,"chapterId":413,"chapterName":"Android群英传","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":5207,"link":"http://mp.weixin.qq.com/s?__biz=MzAxNzMxNzk5OQ==&mid=2649485840&idx=1&sn=52d9db43a5eef79d0cfb6c1f060dd7bd&chksm=83f83b10b48fb20635f99f6101fb6a50c2dc8a4f0c86189d6391dc985bfb2410d08faaceb618&scene=38#wechat_redirect","niceDate":"2018-07-10 00:00","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1531152000000,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/413/1"}],"title":"为什么仅仅学Java还不够，你还需要学 Kotlin ?","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"Android群英传","canEdit":false,"chapterId":413,"chapterName":"Android群英传","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":5271,"link":"http://mp.weixin.qq.com/s?__biz=MzAxNzMxNzk5OQ==&mid=2649485186&idx=2&sn=deffa2efccc08b12d58d4eb1880a4a9d&chksm=83f82682b48faf942880eaea47dfba9e9eb84fcc94e5c7b54e3352053d5f080da9f14ae89418&scene=38#wechat_redirect","niceDate":"2017-02-08 00:00","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1486483200000,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/413/1"}],"title":"Kotlin Primer·第三章·Kotlin 与 Java 混编","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"Android群英传","canEdit":false,"chapterId":413,"chapterName":"Android群英传","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"id":5306,"link":"http://mp.weixin.qq.com/s?__biz=MzAxNzMxNzk5OQ==&mid=2649484800&idx=1&sn=b1d20d83ca546e07145ae3230e929864&chksm=83f82700b48fae169d2e4fee0c47c0a19591f4d5e4eb936e85d815f3ceec43b92d6c646bf89f&scene=38#wechat_redirect","niceDate":"2016-10-31 00:00","niceShareDate":"未知时间","origin":"","prefix":"","projectLink":"","publishTime":1477843200000,"selfVisible":0,"shareDate":null,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/413/1"}],"title":"深入Java源码解析容器类List、Set、Map","type":0,"userId":-1,"visible":1,"zan":0}]
     * offset : 0
     * over : true
     * pageCount : 1
     * size : 20
     * total : 3
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasEntity> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasEntity> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasEntity> datas) {
        this.datas = datas;
    }

    public static class DatasEntity {
        /**
         * apkLink :
         * audit : 1
         * author : Android群英传
         * canEdit : false
         * chapterId : 413
         * chapterName : Android群英传
         * collect : false
         * courseId : 13
         * desc :
         * descMd :
         * envelopePic :
         * fresh : false
         * id : 5207
         * link : http://mp.weixin.qq.com/s?__biz=MzAxNzMxNzk5OQ==&mid=2649485840&idx=1&sn=52d9db43a5eef79d0cfb6c1f060dd7bd&chksm=83f83b10b48fb20635f99f6101fb6a50c2dc8a4f0c86189d6391dc985bfb2410d08faaceb618&scene=38#wechat_redirect
         * niceDate : 2018-07-10 00:00
         * niceShareDate : 未知时间
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1531152000000
         * selfVisible : 0
         * shareDate : null
         * shareUser :
         * superChapterId : 408
         * superChapterName : 公众号
         * tags : [{"name":"公众号","url":"/wxarticle/list/413/1"}]
         * title : 为什么仅仅学Java还不够，你还需要学 Kotlin ?
         * type : 0
         * userId : -1
         * visible : 1
         * zan : 0
         */

        private String apkLink;
        private int audit;
        private String author;
        private boolean canEdit;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String descMd;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String niceShareDate;
        private String origin;
        private String prefix;
        private String projectLink;
        private long publishTime;
        private int selfVisible;
        private Object shareDate;
        private String shareUser;
        private int superChapterId;
        private String superChapterName;
        private String title;
        private int type;
        private int userId;
        private int visible;
        private int zan;
        private List<TagsEntity> tags;

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public int getAudit() {
            return audit;
        }

        public void setAudit(int audit) {
            this.audit = audit;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isCanEdit() {
            return canEdit;
        }

        public void setCanEdit(boolean canEdit) {
            this.canEdit = canEdit;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDescMd() {
            return descMd;
        }

        public void setDescMd(String descMd) {
            this.descMd = descMd;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getNiceShareDate() {
            return niceShareDate;
        }

        public void setNiceShareDate(String niceShareDate) {
            this.niceShareDate = niceShareDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getSelfVisible() {
            return selfVisible;
        }

        public void setSelfVisible(int selfVisible) {
            this.selfVisible = selfVisible;
        }

        public Object getShareDate() {
            return shareDate;
        }

        public void setShareDate(Object shareDate) {
            this.shareDate = shareDate;
        }

        public String getShareUser() {
            return shareUser;
        }

        public void setShareUser(String shareUser) {
            this.shareUser = shareUser;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public List<TagsEntity> getTags() {
            return tags;
        }

        public void setTags(List<TagsEntity> tags) {
            this.tags = tags;
        }

        public static class TagsEntity {
            /**
             * name : 公众号
             * url : /wxarticle/list/413/1
             */

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
