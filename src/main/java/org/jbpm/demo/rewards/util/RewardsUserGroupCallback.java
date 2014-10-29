/**
 * Copyright 2013 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.demo.rewards.util;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;

import org.kie.internal.task.api.UserGroupCallback;

@Alternative

public class RewardsUserGroupCallback implements UserGroupCallback {

    public boolean existsUser(String userId) {
        return userId.equals("adam") || userId.equals("adminUser") || userId.equals("Sam")
        		|| userId.equals("Administrator")|| userId.equals("max");
    }

    public boolean existsGroup(String groupId) {
        return groupId.equals("admin") || groupId.equals("GD")|| groupId.equals("Client");
    }

    public List<String> getGroupsForUser(String userId,
            List<String> groupIds, List<String> allExistingGroupIds) {
    	
        List<String> groups = new ArrayList<String>();
        if (userId.equals("adam"))
            groups.add("GD");
        else if (userId.equals("adminUser"))
            groups.add("admin");
        else if (userId.equals("Sam"))
            groups.add("Client");
        else if (userId.equals("max"))
         groups.add("admin");
        
        return groups;
    }
}
