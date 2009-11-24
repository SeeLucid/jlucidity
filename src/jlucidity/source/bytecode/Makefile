BytecodeCSCIRCDEPTGTS:=			$(wildcard $(SRC)/jlucidity/source/bytecode/Bytecode*.java)

$(BIN)/jlucidity/source/bytecode/BytecodeClassInfo.class:		$(SRC)/jlucidity/source/bytecode/BytecodeClassInfo.java $(BIN)/jlucidity/info/ClassInfo.class $(BIN)/jlucidity/info/VerifiableClassInfo.class


$(CFG)/BytecodeCSCIRCDEP:	$(BytecodeCSCIRCDEPTGTS) \
				$(BIN)/jlucidity/info/ClassInfo.class \
				$(BIN)/jlucidity/info/VerifiableClassInfo.class \
				$(BIN)/jlucidity/source/ClassSource.class
		$(JAVAC) $(JAVAC_FLAGS) $(BytecodeCSCIRCDEPTGTS)
		@touch $@

$(BIN)/jlucidity/source/bytecode/BytecodeClassInfo.class:		$(CFG)/BytecodeCSCIRCDEP
	-@# empty command
$(BIN)/jlucidity/source/bytecode/BytecodeClassSource.class:		$(CFG)/BytecodeCSCIRCDEP
	-@# empty command
$(BIN)/jlucidity/source/bytecode/BytecodeConstructorInfo.class:		$(CFG)/BytecodeCSCIRCDEP
	-@# empty command
$(BIN)/jlucidity/source/bytecode/BytecodeFieldInfo.class:		$(CFG)/BytecodeCSCIRCDEP
	-@# empty command
$(BIN)/jlucidity/source/bytecode/BytecodeMethodInfo.class:		$(CFG)/BytecodeCSCIRCDEP
	-@# empty command
