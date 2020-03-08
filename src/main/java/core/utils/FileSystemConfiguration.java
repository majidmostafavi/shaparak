package core.utils;

import javax.validation.constraints.NotNull;

/**
 * Created by majid on 6/25/17.
 */
public interface FileSystemConfiguration {

    String getConfiguration(@NotNull String key);


    Double getConfigurationDouble(String key);


    String[] getConfigurationArray(String key);


    Boolean getConfigurationBoolean(String key);


    String getConfigurationString(@NotNull String key);

}
