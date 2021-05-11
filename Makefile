timestamp		:= $(shell /bin/date '+%Y%m%d%H%M%S')

usage:
	@echo "-------------------------------------------------"
	@echo "| usage           => 显示菜单"
	@echo "| github          => 推送源代码到github"
	@echo "-------------------------------------------------"

github:
	@git status
	@git add .
	@git commit -m "$(shell /bin/date "+%F %T")"
	@git push

.PHONY: usage github