package ua.nenya.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hover_data")
@NamedQueries({
        @NamedQuery(name = "HoverData.getGrouped", query = "select h from HoverData h group by h.renderingEngine")
})
public class HoverData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rendering_engine")
    private String renderingEngine;

    @Column(name = "browser")
    private String browser;

    @Column(name = "platform")
    private String platform;

    @Column(name = "engine_version")
    private String engineVersion;

    @Column(name = "css_grade")
    private String cssGrade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRenderingEngine() {
        return renderingEngine;
    }

    public void setRenderingEngine(String renderingEngine) {
        this.renderingEngine = renderingEngine;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getCssGrade() {
        return cssGrade;
    }

    public void setCssGrade(String cssGrade) {
        this.cssGrade = cssGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoverData hoverData = (HoverData) o;

        return !(id != null ? !id.equals(hoverData.id) : hoverData.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "HoverData{" +
                "id=" + id +
                ", renderingEngine='" + renderingEngine + '\'' +
                ", browser='" + browser + '\'' +
                ", platform='" + platform + '\'' +
                ", engineVersion='" + engineVersion + '\'' +
                ", cssGrade='" + cssGrade + '\'' +
                '}';
    }

    public HoverData withId(Long id) {
        this.id = id;
        return this;
    }

    public HoverData withRenderingEngine(String renderingEngine) {
        this.renderingEngine = renderingEngine;
        return this;
    }

    public HoverData withBrowser(String browser) {
        this.browser = browser;
        return this;
    }

    public HoverData withPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public HoverData withEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
        return this;
    }

    public HoverData withCssGrade(String cssGrade) {
        this.cssGrade = cssGrade;
        return this;
    }
}
