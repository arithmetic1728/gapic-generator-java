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

package com.google.api.generator.gapic.composer.samplecode;

import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import java.util.Arrays;
import java.util.List;

public final class SampleCodeWriter {

  public static String write(Statement ... statement) {
    return write(Arrays.asList(statement));
  }

  public static String write(List<Statement> statements) {
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    for (Statement statement : statements) {
      statement.accept(visitor);
    }
    return SampleCodeJavaFormatter.format(visitor.write());
  }
}
