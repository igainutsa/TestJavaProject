package manager;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.jpa.hibernate")
public class DBConfigPropertiesHibernet {
	private String ddlAuto;

	public String getDdlAuto() {
		return ddlAuto;
	}

	public void setDdlAuto(String ddlAuto) {
		this.ddlAuto = ddlAuto;
	}

}
