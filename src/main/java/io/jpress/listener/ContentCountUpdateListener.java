/**
 * Copyright (c) 2015-2016, Michael Yang 杨福海 (fuhai999@gmail.com).
 * <p>
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jpress.listener;

import io.jpress.message.Actions;
import io.jpress.message.Message;
import io.jpress.message.MessageListener;
import io.jpress.message.annotation.Listener;
import io.jpress.model.Taxonomy;
import io.jpress.model.query.TaxonomyQuery;

import java.math.BigInteger;

@Listener(action = Actions.CONTENT_COUNT_UPDATE)
public class ContentCountUpdateListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        BigInteger[] ids = message.getData();
        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                Taxonomy t = TaxonomyQuery.me().findById(ids[i]);
                if (t != null)
                    t.updateContentCount();
            }
        }
    }


}
