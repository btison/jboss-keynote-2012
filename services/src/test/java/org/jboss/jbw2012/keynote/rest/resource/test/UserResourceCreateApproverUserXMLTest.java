package org.jboss.jbw2012.keynote.rest.resource.test;

import javax.ws.rs.core.MultivaluedMap ;

import org.jboss.arquillian.container.test.api.RunAsClient ;
import org.jboss.arquillian.junit.Arquillian ;
import org.jboss.jbw2012.keynote.rest.resource.UserResource ;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl ;
import org.junit.Test ;
import org.junit.runner.RunWith ;

@RunWith(Arquillian.class)
@RunAsClient
public class UserResourceCreateApproverUserXMLTest extends BaseResourceTest
{
    protected static final String USER_RESOURCE_PREFIX = RESOURCE_PREFIX + UserResource.RESOURCE_PREFIX ;
    
    @Test
    public void testCreateUserAsXML()
        throws Exception
    {
        runXMLPostTest(USER_RESOURCE_PREFIX, "/", "xml/User_createApproverUser_request.xml", "xml/User_createApproverUser_response.xml") ;
        
        final MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl<String, String>() ;
        queryParams.add("startPosition", "0") ;
        queryParams.add("maxResults", "10") ;
        
        runXMLGetTest(USER_RESOURCE_PREFIX, "/", queryParams, "xml/User_createApproverUser_getUsers_response.xml") ;
    }
}
