$$($(SRC)/jlucidity/info/ClassInfo.java_DEPS):=		$(SRC)/jlucidity/info/ClassInfo.java $(BIN)/jlucidity/info/TypeInfo.class  $(BIN)/jlucidity/source/ClassSource.class \
						$(BIN)/jlucidity/info/ClassName.class $(BIN)/jlucidity/info/FieldInfo.class $(BIN)/jlucidity/info/MethodInfo.class \
						$(BIN)/jlucidity/info/ConstructorInfo.class $(BIN)/jlucidity/source/SourceProduct.class

$(BIN)/jlucidity/info/TypeInfo.class:			$(SRC)/jlucidity/info/TypeInfo.java
$(BIN)/jlucidity/info/ClassInfo.class:			$(CFG)/SOURCECIRCDEP
	-@# empty command
#$(BIN)/jlucidity/info/ClassInfo.class:			$(SRC)/jlucidity/info/ClassInfo.java $(BIN)/jlucidity/info/TypeInfo.class \
#                                                        $(BIN)/jlucidity/info/ClassName.class $(BIN)/jlucidity/info/FieldInfo.class $(BIN)/jlucidity/info/MethodInfo.class \
#                                                        $(BIN)/jlucidity/info/ConstructorInfo.class | $(CFG)/SOURCECIRCDEP
$(BIN)/jlucidity/info/PackageInfo.class:		$(SRC)/jlucidity/info/PackageInfo.java $(BIN)/jlucidity/info/TypeInfo.class $(BIN)/jlucidity/source/ClassSource.class
$(BIN)/jlucidity/info/ConstructorInfo.class:		$(SRC)/jlucidity/info/ConstructorInfo.java $(BIN)/jlucidity/info/TypeInfo.class
$(BIN)/jlucidity/info/MethodInfo.class:		$(SRC)/jlucidity/info/MethodInfo.java $(BIN)/jlucidity/info/FieldInfo.class  $(BIN)/jlucidity/info/TypeInfo.class 
$(BIN)/jlucidity/info/FieldInfo.class:			$(SRC)/jlucidity/info/FieldInfo.java $(BIN)/jlucidity/info/TypeInfo.class

$(BIN)/jlucidity/info/ClassName.class:			$(SRC)/jlucidity/info/ClassName.java	$(BIN)/jlucidity/info/PackageName.class
$(BIN)/jlucidity/info/PackageName.class:		$(SRC)/jlucidity/info/PackageName.java $(BIN)/jlucidity/lang/JavaLanguage.class

$(BIN)/jlucidity/info/ClassName.class:			$(SRC)/jlucidity/info/ClassName.java
$(BIN)/jlucidity/info/PackageName.class:		$(SRC)/jlucidity/info/PackageName.java $(BIN)/jlucidity/lang/JavaLanguage.class

$(BIN)/jlucidity/info/VerifiableClassInfo.class:			$(SRC)/jlucidity/info/VerifiableClassInfo.java $(BIN)/jlucidity/info/ClassName.class
