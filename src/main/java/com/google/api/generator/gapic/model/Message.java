// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.model;

import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

@AutoValue
public abstract class Message {
  public abstract String name();

  // TODO(unsupported): oneof fields are parsed as separate ones because field flattening refers to
  // a specific field.
  public abstract ImmutableList<Field> fields();

  public abstract TypeNode type();

  public abstract ImmutableMap<String, Field> fieldMap();

  // The resource name annotation (and definition) in this message. Optional.
  // Expected dto be empty for messages that have no such definition.
  @Nullable
  public abstract ResourceName resource();

  // The nested types in left-to-right order, if any.
  // Example: com.google.Foo.Bar.Car.ThisType will have the outer types listed in the order
  // [Foo, Bar, Car].
  public abstract ImmutableList<String> outerNestedTypes();

  public abstract Builder toBuilder();

  public boolean hasResource() {
    return resource() != null;
  }

  /** Returns the first list repeated field in a message, unwrapped from its list type. */
  @Nullable
  public Field findAndUnwrapFirstRepeatedField() {
    for (Field field : fields()) {
      if (field.isRepeated() && !field.isMap()) {
        Reference repeatedGenericRef = field.type().reference().generics().get(0);
        return field.toBuilder().setType(TypeNode.withReference(repeatedGenericRef)).build();
      }
    }
    return null;
  }

  public static Builder builder() {
    return new AutoValue_Message.Builder().setOuterNestedTypes(Collections.emptyList());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setName(String name);

    public abstract Builder setFields(List<Field> fields);

    public abstract Builder setType(TypeNode type);

    public abstract Builder setResource(ResourceName resource);

    public abstract Builder setOuterNestedTypes(List<String> outerNestedTypes);

    abstract Builder setFieldMap(Map<String, Field> fieldMap);

    abstract ImmutableList<Field> fields();

    abstract Message autoBuild();

    public Message build() {
      setFieldMap(fields().stream().collect(Collectors.toMap(f -> f.name(), f -> f)));
      return autoBuild();
    }
  }
}
