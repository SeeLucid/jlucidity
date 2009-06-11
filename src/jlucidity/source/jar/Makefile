$$($(SRC)/jlucidity/source/jar/JarClassSource.java_DEPS):= 	$(SRC)/jlucidity/source/jar/JarClassSource.java $(BIN)/jlucidity/source/ClassSource.class $(CFG)/JARCSCIRCDEP
$$($(SRC)/jlucidity/source/jar/JarClassInfo.java_DEPS):=	$(SRC)/jlucidity/source/jar/JarClassInfo.java $(BIN)/jlucidity/source/bytecode/BytecodeClassInfo.class $(BIN)/jlucidity/source/jar/JarClassSource.class

JARCSCIRCDEPTGTS:=			$(SRC)/jlucidity/source/jar/JarClassSource.java $(SRC)/jlucidity/source/jar/JarClassInfo.java
#$(BIN)/JARCSCIRCDEP:	$(JARCSCIRCDEPTGTS) $($(SRC)/jlucidity/source/jar/JarClassSource.java_DEPS) \
#                                $($(SRC)/jlucidity/source/jar/JarClassInfo.java_DEPS)
#                $(JAVAC) $(JAVAC_FLAGS) $(JARCSCIRCDEPTGTS)
#                touch $@

$(CFG)/JARCSCIRCDEP:	$(JARCSCIRCDEPTGTS) \
				$(BIN)/jlucidity/source/ClassSource.class \
				$(BIN)/jlucidity/source/bytecode/BytecodeClassInfo.class \
				$(BIN)/jlucidity/source/jar/JarClassName.class
		$(JAVAC) $(JAVAC_FLAGS) $(JARCSCIRCDEPTGTS)
		@touch $@

$(BIN)/jlucidity/source/jar/JarClassSource.class:		$(CFG)/JARCSCIRCDEP
	-@# empty command
#$(BIN)/jlucidity/source/jar/JarClassSource.class:		$(SRC)/jlucidity/source/jar/JarClassSource.java $(BIN)/jlucidity/source/ClassSource.class | $(CFG)/JARCSCIRCDEP

$(BIN)/jlucidity/source/jar/JarClassInfo.class:		$(CFG)/JARCSCIRCDEP
	-@# empty command
#$(BIN)/jlucidity/source/jar/JarClassInfo.class:		$(SRC)/jlucidity/source/jar/JarClassInfo.java $(BIN)/jlucidity/source/reflect/ReflectionClassInfo.class | $(CFG)/JARCSCIRCDEP

$(BIN)/jlucidity/source/jar/JarClassName.class:		$(SRC)/jlucidity/source/jar/JarClassName.java $(BIN)/jlucidity/info/ClassName.class
