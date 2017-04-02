package ua.nenya.dto;

import java.io.Serializable;
import java.util.Objects;

public class HoverDataDTO implements Serializable {

    private Long id;

    private String renderingEngine;

    private String browser;

    private String platform;

    private String engineVersion;

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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HoverDataDTO hoverDataDTO = (HoverDataDTO) o;

        if ( ! Objects.equals(id, hoverDataDTO.id)) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "HoverDataDTO{" +
                "id=" + id +
                ", renderingEngine='" + renderingEngine + "'" +
                ", browser='" + browser + "'" +
                ", platform='" + platform + "'" +
                ", engineVersion='" + engineVersion + "'" +
                ", cssGrade='" + cssGrade + "'" +
                '}';
    }
    public HoverDataDTO withId(Long id) {
        this.id = id;
        return this;
    }

    public HoverDataDTO withRenderingEngine(String renderingEngine) {
        this.renderingEngine = renderingEngine;
        return this;
    }

    public HoverDataDTO withBrowser(String browser) {
        this.browser = browser;
        return this;
    }

    public HoverDataDTO withPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public HoverDataDTO withEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
        return this;
    }

    public HoverDataDTO withCssGrade(String cssGrade) {
        this.cssGrade = cssGrade;
        return this;
    }
}
