$$($(SRC)/jlucidity/source/ClassSource.java_DEPS):=	$(SRC)/jlucidity/source/ClassSource.java $(BIN)/jlucidity/info/ClassName.class $(BIN)/jlucidity/info/PackageName.class
$$($(SRC)/jlucidity/source/SourceProduct.java_DEPS):=	$(SRC)/jlucidity/source/SourceProduct.java $(BIN)/jlucidity/source/ClassSource.class

SOURCECIRCDEPTGTS:=			$(SRC)/jlucidity/source/ClassSource.java $(SRC)/jlucidity/info/ClassInfo.java $(SRC)/jlucidity/source/SourceProduct.java $($(SRC)/jlucidity/source/ClassSource.java_DEPS)
##CLASS_FILES:= $(subst $(SRC),$(BIN),$(patsubst %.java,%.class,$(wildcard $(SRC)/*.java)))
#$(BIN)/SOURCECIRCDEP:	$(SOURCECIRCDEPTGTS) $($(SRC)/jlucidity/source/ClassSource.java_DEPS) \
#                                $($(SRC)/jlucidity/info/ClassInfo.java_DEPS)  $($(SRC)/jlucidity/source/SourceProduct.java_DEPS)
#                echo $(patsubst %.java,%.foo,$+)
#                $(JAVAC) $(JAVAC_FLAGS) $(patsubst %.class,%.java,$+)
#                touch $@
#

$(CFG)/SOURCECIRCDEP:	$(SOURCECIRCDEPTGTS) \
				$(BIN)/jlucidity/info/TypeInfo.class \
				$(BIN)/jlucidity/info/ClassName.class $(BIN)/jlucidity/info/FieldInfo.class $(BIN)/jlucidity/info/MethodInfo.class \
				$(BIN)/jlucidity/info/ConstructorInfo.class \
				$(BIN)/jlucidity/info/ClassName.class $(BIN)/jlucidity/info/PackageName.class
		$(JAVAC) $(JAVAC_FLAGS) $(SOURCECIRCDEPTGTS)
		@touch $@

$(BIN)/jlucidity/source/ClassSource.class:		$(CFG)/SOURCECIRCDEP
	-@# empty command
#$(BIN)/jlucidity/source/ClassSource.class:		$(SRC)/jlucidity/source/ClassSource.java $(BIN)/jlucidity/ClassName.class $(BIN)/jlucidity/PackageName.class	 | $(CFG)/SOURCECIRCDEP

$(BIN)/jlucidity/source/SourceProduct.class:		$(CFG)/SOURCECIRCDEP $($(SRC)/jlucidity/source/SourceProduct.java_DEPS)
	-@# empty command
#$(BIN)/jlucidity/SourceProduct.class:		$(SRC)/jlucidity/SourceProduct.java | $(CFG)/SOURCECIRCDEP

include $(SRC)/jlucidity/source/jar/Makefile
include $(SRC)/jlucidity/source/reflect/Makefile
include $(SRC)/jlucidity/source/file/Makefile
include $(SRC)/jlucidity/source/bytecode/Makefile
