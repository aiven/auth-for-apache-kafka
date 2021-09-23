/*
 * Copyright 2021 Aiven Oy https://aiven.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.aiven.kafka.auth.nameformatters;

import org.apache.kafka.common.resource.ResourceType;

public final class LegacyResourceTypeNameFormatter {
    public static String format(final ResourceType resourceType) {
        switch (resourceType) {
            case UNKNOWN:
                return "Unknown";

            case ANY:
                return "Any";

            case TOPIC:
                return "Topic";

            case GROUP:
                return "Group";

            case CLUSTER:
                return "Cluster";

            case TRANSACTIONAL_ID:
                return "TransactionalId";

            case DELEGATION_TOKEN:
                return "DelegationToken";

            default:
                // In case there's an unknown resource type, fall back to the slow path.
                return LegacyNameFormatter.format(resourceType.name());
        }
    }
}
