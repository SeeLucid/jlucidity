# Makefile for JLucidity
include Config.mk

gendirs:= $(BIN) $(CFG)
$(foreach dir,$(gendirs),$(shell $(MKDIR) $(dir) 2>/dev/null))

#CLASS_FILES:= $(subst $(SRC),$(BIN),$(patsubst %.java,%.class,$(wildcard $(SRC)/*.java)))
CLASS_FILES:= $(subst $(SRC),$(BIN),$(patsubst %.java,%.class,$(shell find $(SRC) -name *.java)))

#doc 
all:	tags $(CLASS_FILES)

include src/Makefile

#$(wildcard $(BIN)/*.class):	$(BIN)
#                        mkdir $(BIN)

# $(wildcard $(SRC)/*.java)
tags:	$(shell find $(SRC) -name *.java)
	-@which ctags > /dev/null && echo "Running ctags"
	-@ctags -R $(SRC)/*

#$(wildcard *.java)
#$(wildcard $(SRC)/*.java)
doc:		$(shell find $(SRC) -name *.java)
		javadoc $(JAVADOC_FLAGS) -sourcepath $(SRC) -subpackages jlucidity
		@touch $@
clean:	cleansrc
	@$(RM) $(BIN)/*.class
	@$(RM) tags
	@$(RMDIR) $(BIN)
	@$(RMDIR) $(CFG)

cleandoc:
	@$(RMDIR) doc

cleanall:	clean cleandoc

.PHONY:		all clean cleandoc cleanall
