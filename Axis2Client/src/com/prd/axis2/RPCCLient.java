package com.prd.axis2;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

/**
 * 测试RPC调用webservice方法
 * 
 * @author 李富
 *
 */

public class RPCCLient {

	public static void main(String[] args) throws Exception {
		// 第一步：创建RPCServiceClient对象
		RPCServiceClient client = new RPCServiceClient();
		Options option = client.getOptions();

		// 第二步：创建EndpointReference，并指定要访问WebService的url(不包含wsdl)
		EndpointReference epr = new EndpointReference(
				"http://localhost:8080/axis2/services/MyService");
		option.setTo(epr);

		// 第三步：创建描述WebService方法参数值的Object[]对象
		Object[] params = new Object[]{"李富"};

		// 第四步：创建描述WebService方法返回值类型的Class[]对象
		Class[] classes = new Class[]{String.class};

		// 第五步：创建QName对象，并指定要调用的WebService方法
		QName qn = new QName("http://axis.prd.com","sayHello");

		// 第六步：使用RPCServiceClient类的invokeBlocking方法调用WebService的方法
		// invokeBlocking方法采用是同步的方法来调用WebService。
		
		String str = (String) client.invokeBlocking(qn, params,classes)[0];
		System.out.println(str);

	}

}
