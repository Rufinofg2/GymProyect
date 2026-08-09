#!/usr/bin/env bash
#
# Configura la branch protection de "main" usando GitHub CLI (gh).
# Requisitos:
#   1. Tener gh instalado y autenticado: gh auth login
#   2. Ejecutar este script desde la raíz del repo (o pasar owner/repo como args)
#
# Uso:
#   ./scripts/setup-branch-protection.sh <owner> <repo> [branch]
#   ej: ./scripts/setup-branch-protection.sh mi-org mi-repo main

set -euo pipefail

OWNER="${1:?Falta el owner/organización. Uso: $0 <owner> <repo> [branch]}"
REPO="${2:?Falta el nombre del repo. Uso: $0 <owner> <repo> [branch]}"
BRANCH="${3:-main}"

echo "🔒 Configurando protección para la rama '${BRANCH}' en ${OWNER}/${REPO}..."

gh api \
  --method PUT \
  -H "Accept: application/vnd.github+json" \
  -H "X-GitHub-Api-Version: 2022-11-28" \
  "/repos/${OWNER}/${REPO}/branches/${BRANCH}/protection" \
  -f "required_status_checks[strict]=true" \
  -f "required_status_checks[checks][][context]=All checks passed" \
  -f "enforce_admins=true" \
  -f "required_pull_request_reviews[dismiss_stale_reviews]=true" \
  -f "required_pull_request_reviews[require_code_owner_reviews]=true" \
  -f "required_pull_request_reviews[required_approving_review_count]=1" \
  -f "restrictions=null" \
  -f "required_linear_history=true" \
  -f "allow_force_pushes=false" \
  -f "allow_deletions=false" \
  -f "required_conversation_resolution=true" \
  -f "lock_branch=false"

echo "✅ Listo. Reglas aplicadas sobre '${BRANCH}':"
echo "   - No se permite push directo (ni siquiera admins, por enforce_admins=true)"
echo "   - Todo cambio requiere Pull Request"
echo "   - El PR requiere al menos 1 aprobación (y CODEOWNERS si aplica)"
echo "   - El check 'All checks passed' del workflow CI debe estar en verde"
echo "   - No se permiten force-pushes ni borrar la rama"
echo "   - Se exige historial lineal (sin merge commits)"
echo "   - Las conversaciones del PR deben quedar resueltas antes de mergear"
echo ""
echo "ℹ️  Nota: si tu plan de GitHub no soporta 'required_conversation_resolution'"
echo "   o 'required_linear_history' en repos privados, quitá esas líneas."
