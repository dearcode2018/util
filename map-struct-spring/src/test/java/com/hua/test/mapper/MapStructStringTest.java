/**
 * 描述: 
 * MapStructStringTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.mapper;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hua.ApplicationStarter;
import com.hua.dto.OrderQueryDTO;
import com.hua.entity.AddressEntity;
import com.hua.entity.OrderEntity;
import com.hua.mapper.OrderExMapper;
import com.hua.mapper.OrderMapper;
import com.hua.test.BaseTest;
import com.hua.util.JacksonUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MapStructStringTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
// for Junit 5.x
@ExtendWith(SpringExtension.class)
//@WebAppConfiguration(value = "src/main/webapp")
@SpringBootTest(classes = {ApplicationStarter.class}, 
webEnvironment = SpringBootTest.WebEnvironment.NONE)
//@MapperScan(basePackages = {"com.hua.mapper"})
public final class MapStructStringTest extends BaseTest {

	
	/*
	配置方式1: 
	@WebAppConfiguration(value = "src/main/webapp")  
	@ContextConfiguration(locations = {
			"classpath:conf/xml/spring-bean.xml", 
			"classpath:conf/xml/spring-config.xml", 
			"classpath:conf/xml/spring-mvc.xml", 
			"classpath:conf/xml/spring-service.xml"
		})
	@ExtendWith(SpringExtension.class)
	
	配置方式2: 	
	@WebAppConfiguration(value = "src/main/webapp")  
	@ContextHierarchy({  
		 @ContextConfiguration(name = "parent", locations = "classpath:spring-config.xml"),  
		 @ContextConfiguration(name = "child", locations = "classpath:spring-mvc.xml")  
		}) 
	@ExtendWith(SpringExtension.class)
	 */
	
	/**
	 * 而启动spring 及其mvc环境，然后通过注入方式，可以走完 spring mvc 完整的流程.
	 * 
	 */
	@Resource
	private OrderMapper orderMapper;
	
	@Resource
	private OrderExMapper orderExMapper;
	
	/**
	 * 引当前项目用其他项目之后，然后可以使用
	 * SpringJunitTest模板测试的其他项目
	 * 
	 * 可以使用所引用目标项目的所有资源
	 * 若引用的项目的配置与本地的冲突或无法生效，需要
	 * 将目标项目的配置复制到当前项目同一路径下
	 * 
	 */
	
	
	/**
	 * 
	 * 描述: 同类型同名，无须配置
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void entity2QueryDTO() {
		try {
			OrderEntity entity = new OrderEntity();
			entity.setId(123L);
			entity.setOrderSn("SN234349839493");
			entity.setOrderType(2);
			entity.setReceiverKeyword("13018750898");
			entity.setSourceType(2);
			entity.setStatus(1);
			
			OrderQueryDTO dto = orderMapper.entity2QueryDTO(entity);
			System.out.println(JacksonUtil.writeAsString(dto));
			assertTrue(entity.getOrderSn().equals(dto.getOrderSn()));
			assertTrue(entity.getReceiverKeyword().equals(dto.getReceiverKeyword()));
			
		} catch (Exception e) {
			log.error("entity2QueryDTO =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 同类型不同名
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void entity2QueryDTO2() {
		try {
			OrderEntity entity = new OrderEntity();
			entity.setId(123L);
			entity.setOrderSn("SN234349839493");
			entity.setOrderType(2);
			entity.setReceiverKeyword("13018750898");
			entity.setSourceType(2);
			entity.setStatus(1);
			entity.setExtend01("扩展1");
			entity.setRemark("备注啊啊啊1");
			
			OrderQueryDTO dto = orderMapper.entity2QueryDTOFull(entity);
			System.out.println(JacksonUtil.writeAsString(dto));
			assertTrue(entity.getExtend01().equals(dto.getExtendFirst()));
			assertTrue(entity.getRemark().equals(dto.getDescription()));
			
		} catch (Exception e) {
			log.error("entity2QueryDTO2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 不同类型同名
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void entity2QueryDTO3() {
		try {
			OrderEntity entity = new OrderEntity();
			entity.setId(123L);
			entity.setOrderSn("SN234349839493");
			entity.setOrderType(2);
			entity.setReceiverKeyword("13018750898");
			entity.setSourceType(2);
			entity.setStatus(1);
			entity.setExtend01("扩展1");
			entity.setRemark("备注啊啊啊1");
			entity.setDate("2020-06-01");
			entity.setDateTime(LocalDateTime.now());
			entity.setPrice(12.3289430);
			
			OrderQueryDTO dto = orderMapper.entity2QueryDTO3(entity);
			System.out.println(JacksonUtil.writeAsString(dto));
			assertTrue(entity.getReceiverKeyword().equals(dto.getReceiverKeyword()));
			
		} catch (Exception e) {
			log.error("entity2QueryDTO3 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 不同类型不同名
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void entity2QueryDTO4() {
		try {
			OrderEntity entity = new OrderEntity();
			entity.setId(123L);
			entity.setOrderSn("SN234349839493");
			entity.setOrderType(2);
			entity.setReceiverKeyword("13018750898");
			entity.setSourceType(2);
			entity.setStatus(1);
			
			entity.setExtend01("扩展1");
			entity.setRemark("备注啊啊啊1");
			
			entity.setDate("2020-06-01");
			entity.setDateTime(LocalDateTime.now());
			entity.setPrice(11.3289430);
			
			entity.setDateTimeType(LocalDateTime.now());
			entity.setDateString("2020-06-01");
			
			OrderQueryDTO dto = orderMapper.entity2QueryDTO4(entity);
			System.out.println(JacksonUtil.writeAsString(dto));
			assertTrue(entity.getOrderSn().equals(dto.getOrderSn()));
			assertTrue(entity.getReceiverKeyword().equals(dto.getReceiverKeyword()));
			
		} catch (Exception e) {
			log.error("entity2QueryDTO4 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 完整的
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void entity2QueryDTOFull() {
		try {
			OrderEntity entity = new OrderEntity();
			entity.setId(123L);
			entity.setOrderSn("SN234349839493");
			entity.setOrderType(2);
			entity.setReceiverKeyword("13018750898");
			entity.setSourceType(2);
			entity.setStatus(1);
			entity.setExtend01("扩展1");
			entity.setRemark("备注啊啊啊1");
			
			entity.setDate("2020-06-01");
			entity.setDateTime(LocalDateTime.now());
			entity.setPrice(11.3289430);
			entity.setDateTimeType(LocalDateTime.now());
			entity.setDateString("2020-06-01");
			OrderQueryDTO dto = orderMapper.entity2QueryDTOFull(entity);
			System.out.println(JacksonUtil.writeAsString(dto));
			assertTrue(entity.getOrderSn().equals(dto.getOrderSn()));
			assertTrue(entity.getReceiverKeyword().equals(dto.getReceiverKeyword()));
			assertTrue(entity.getExtend01().equals(dto.getExtendFirst()));
			assertTrue(entity.getRemark().equals(dto.getDescription()));
			
		} catch (Exception e) {
			log.error("entity2QueryDTOFull =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 同类型同名，无须配置
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void entity2QueryDTOExpression1() {
		try {
			OrderEntity entity = new OrderEntity();
			entity.setId(123L);
			entity.setOrderSn("SN234349839493");
			entity.setOrderType(2);
			entity.setReceiverKeyword("13018750898");
			entity.setSourceType(2);
			entity.setStatus(1);
			entity.setSomeValue("天气真好，Jon");
			
			OrderQueryDTO dto = orderMapper.entity2QueryDTOExpression1(entity);
			System.out.println(JacksonUtil.writeAsString(dto));
			assertTrue(entity.getOrderSn().equals(dto.getOrderSn()));
			assertTrue(entity.getReceiverKeyword().equals(dto.getReceiverKeyword()));
			
		} catch (Exception e) {
			log.error("entity2QueryDTOExpression1 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 同类型同名，无须配置
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void entity2QueryDTOExpression2() {
		try {
			OrderEntity entity = new OrderEntity();
			entity.setId(123L);
			entity.setOrderSn("SN234349839493");
			entity.setOrderType(2);
			entity.setReceiverKeyword("13018750898");
			entity.setSourceType(2);
			entity.setStatus(1);
			entity.setSomeValue("天气真好，Jon");
			
			OrderMapper mapper = Mappers.getMapper(OrderMapper.class);
			//OrderQueryDTO dto = mapper.entity2QueryDTOExpression2(entity);
			//System.out.println(JacksonUtil.writeAsString(dto));
			//assertTrue(entity.getOrderSn().equals(dto.getOrderSn()));
			//assertTrue(entity.getReceiverKeyword().equals(dto.getReceiverKeyword()));
			
		} catch (Exception e) {
			log.error("entity2QueryDTOExpression2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 同类型同名，无须配置
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void queryDTO2Entity() {
		try {
			OrderQueryDTO dto = new OrderQueryDTO();
			dto.setOrderSn("SN234349839493");
			dto.setOrderType(2);
			dto.setReceiverKeyword("13018750898");
			dto.setSourceType(2);
			dto.setStatus(1);
			
			dto.setDate(LocalDate.now());
			dto.setDateTime("2020-06-01 15:42:29");
			dto.setPrice("11.3289430");
			dto.setDateTimeString("2020-06-01 15:42:29");
			dto.setDateType(LocalDate.now());
			
			OrderEntity entity = orderExMapper.queryDTO2Entity(dto);
			System.out.println(JacksonUtil.writeAsString(entity));
			assertTrue(dto.getOrderSn().equals(entity.getOrderSn()));
			assertTrue(dto.getReceiverKeyword().equals(entity.getReceiverKeyword()));
			
		} catch (Exception e) {
			log.error("queryDTO2Entity =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 完整的
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void entity2QueryDTOMulti() {
		try {
			OrderEntity entity = new OrderEntity();
			entity.setId(123L);
			entity.setOrderSn("SN234349839493 ");
			entity.setOrderType(2);
			entity.setReceiverKeyword("13018750898");
			entity.setSourceType(2);
			entity.setStatus(1);
			entity.setExtend01("扩展1");
			entity.setRemark("备注啊啊啊1");
			
			entity.setDate("2020-06-01");
			entity.setDateTime(LocalDateTime.now());
			entity.setPrice(11.3289430);
			entity.setDateTimeType(LocalDateTime.now());
			entity.setDateString("2020-06-01");
			AddressEntity entity2 = new AddressEntity();
			entity2.setProvince("广东");
			entity2.setCity("中山市");
			OrderQueryDTO dto = orderExMapper.entity2QueryDTOMulti(entity, entity2);
			System.out.println(JacksonUtil.writeAsString(dto));
			//assertTrue(entity.getOrderSn().equals(dto.getOrderSn()));
			assertTrue(entity.getReceiverKeyword().equals(dto.getReceiverKeyword()));
			assertTrue(entity.getExtend01().equals(dto.getExtendFirst()));
			//assertTrue(entity.getRemark().equals(dto.getDescription()));
			
		} catch (Exception e) {
			log.error("entity2QueryDTOFull =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testUpdate() {
		try {
			OrderQueryDTO dto = new OrderQueryDTO();
			dto.setOrderSn("SN234349839493");
			dto.setOrderType(2);
			dto.setReceiverKeyword("13018750898");
			dto.setSourceType(2);
			dto.setStatus(1);
			
			dto.setDate(LocalDate.now());
			dto.setDateTime("2020-06-01 15:42:29");
			dto.setPrice("11.3289430");
			dto.setDateTimeString("2020-06-01 15:42:29");
			dto.setDateType(LocalDate.now());
			AddressEntity address = new AddressEntity();
			address.setProvince("广东");
			address.setCity("中山市");
			orderExMapper.update(address, dto);
			assertTrue(dto.getCityName().equals(address.getCity()));
			System.out.println(JacksonUtil.writeAsString(dto));
			
		} catch (Exception e) {
			log.error("testUpdate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testTemp")
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testCommon")
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testSimple")
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
		dynamicTest(null, null);
		
	}

}
