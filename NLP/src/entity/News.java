package entity;

public class News {

    private int NewsId;
    private String DataSetId;
    private String NewsDate;
    private String Actors;
    private String Sentiment;
    private String Type;
    private String Value;
    private String FakeTruthMatchNewsId;
    private String Topic;
    private String Url;
    private String NewsTitle;
    private String NewsDetail;
    private String GdeltFactor;
    private String GlobalEventId;

    public int getNewsId() {
        return NewsId;
    }

    public void setNewsId(int NewsId) {
        this.NewsId = NewsId;
    }

    public String getDataSetId() {
        return DataSetId;
    }

    public void setDataSetId(String DataSetId) {
        this.DataSetId = DataSetId;
    }

    public String getNewsDate() {
        return NewsDate;
    }

    public void setNewsDate(String NewsDate) {
        this.NewsDate = NewsDate;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String Actors) {
        this.Actors = Actors;
    }

    public String getSentiment() {
        return Sentiment;
    }

    public void setSentiment(String Sentiment) {
        this.Sentiment = Sentiment;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    public String getFakeTruthMatchNewsId() {
        return FakeTruthMatchNewsId;
    }

    public void setFakeTruthMatchNewsId(String FakeTruthMatchNewsId) {
        this.FakeTruthMatchNewsId = FakeTruthMatchNewsId;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String Topic) {
        this.Topic = Topic;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String NewsTitle) {
        this.NewsTitle = NewsTitle;
    }

    public String getNewsDetail() {
        return NewsDetail;
    }

    public void setNewsDetail(String NewsDetail) {
        this.NewsDetail = NewsDetail;
    }

    public String getGdeltFactor() {
        return GdeltFactor;
    }

    public void setGdeltFactor(String GdeltFactor) {
        this.GdeltFactor = GdeltFactor;
    }

    public String getGlobalEventId() {
        return GlobalEventId;
    }

    public void setGlobalEventId(String GlobalEventId) {
        this.GlobalEventId = GlobalEventId;
    }
}
