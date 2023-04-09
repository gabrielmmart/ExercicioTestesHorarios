cd ExercicioDosHorarios
sudo apt install mailutils
echo "Pipeline executado"
echo ${{ env.NOTIF_EMAIL}
echo "Mandando e-mail com mail do linux" | mail -s "meu email deu tudo certo" ${NOTIF_EMAIL}