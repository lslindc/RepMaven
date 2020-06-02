package utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisConfigUtil {

	private static final String CONFIG_FILE_NAME = "mybatis-config.xml";
	private static final Logger LOGGER = Logger.getLogger(MyBatisConfigUtil.class);

	private static SqlSessionFactory sqlSessionFactory = null;

	public static SqlSessionFactory getSqlSessionFactory() {
		try {
			Reader reader = Resources.getResourceAsReader(CONFIG_FILE_NAME);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			LOGGER.error(e.getStackTrace());
		}
		return sqlSessionFactory;
	}

}
